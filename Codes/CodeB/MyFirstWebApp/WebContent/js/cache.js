/**
 *  Get Cache Data from the Server
 */
window.addEventListener("load",getCacheData);
function printIt(data){
	var city = document.querySelector("#city");
	for(let object of data.data){
		var option = document.createElement("option");
		option.innerText = object.descr;
		option.value=object.name;
		city.appendChild(option);
	}
}


function getCacheData(){
	fetch("http://localhost:8080/MyFirstWebApp/cache",
			{method:"post" ,body: {"key":"city"}}).then(response=>{
		response.json().then(data=>{
			console.log("Data is ",data);
			printIt(data);
		}).catch(err=>{
			console.log("Invalid json ",err);
		}).catch(err=>{
			console.log("Can't Talk to Server ",err);
		})
	});
}