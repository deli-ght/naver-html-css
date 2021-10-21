
 function draw(type, eventNode){
 	let box = eventNode.parentNode;
 	var insertItem = eventNode.parentNode.parentNode;
 	if (type == "TODO") {
 		type = "DOING"
 		}
 	else if (type == "DOING") {
 		type = "DONE"
 		box.removeChild(eventNode);
 	}
 	
 	let list = document.querySelector("section[id=" + type + "]");
 	list.appendChild(insertItem);
 }
 
 function changeButtonClick(id, eventNode){
 	
 	let httpRequest = new XMLHttpRequest();
 	let type = eventNode.parentNode.parentNode.parentNode.getAttribute("id");
 	
 	httpRequest.addEventListener("load", function(){
 		if (this.responseText == "success"){
 			draw(type, eventNode);
 	}
 	});
 	
 	httpRequest.open("GET", "javaType?id=" + id + "&type=" +type);
 	httpRequest.send();
 	
}

function removeAll(){
	let httpRequest = new XMLHttpRequest();	
	
	const todoblock = document.querySelectorAll(".todoBlock");
	
	todoblock.forEach(el => el.outerHTML ="");
	
	
	httpRequest.open("GET", "todoRemove");
	httpRequest.send();
}