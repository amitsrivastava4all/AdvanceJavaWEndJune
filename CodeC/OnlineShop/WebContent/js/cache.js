/**
 *  Get Cache Data from the Server
 */
function convert(source, target, amount,id){
	//var source = document.getElementById("source").value;
	//var target = document.getElementById("dest").value;
	source = source.toUpperCase();
	target = target.toUpperCase();
	var url = `https://free.currencyconverterapi.com/api/v6/convert?q=${source}_${target}&compact=y`;
	fetch(url).then(response=>{
		response.json().then(data=>{
			console.log("Data is ",data);
			var myKey = source + "_"+target;
			document.getElementById(id).innerText = amount/data[myKey].val;
			/*for(let key in data){
				console.log("Key is ",key, " Data ",data[key]);
				document.getElementById("print").innerText = data[key].val;
				break;
				//data.USD_INR
			}*/
			
		}).catch(err=>{
			console.log("Error is ",err);
		})
	},err=>{
		console.log("::: Error is ",err);
	})
}
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
	fetch("http://localhost:8080/OnlineShop/cache",
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