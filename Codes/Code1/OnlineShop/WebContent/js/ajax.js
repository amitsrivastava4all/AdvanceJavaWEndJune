/**
 * 
 */
function doAjax(url, uri){
	fetch(url+uri).then(response=>{
			response.text().then(data=>{
				console.log("Data is ",data);
				document.querySelector("#maindiv").innerHTML = data;
			}).catch(e=>{
				console.log("error is ",e);
			})
	}).catch(err=>{
		alert("Can't Access the Page....");
	})
}