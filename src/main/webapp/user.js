function fetchData() {
	fetch("http://localhost:8080/UserTest/user/detail/get").then(response => {
		console.log(response);
		if(!response.ok)
		{
			return Error("ERROR")
		}
		return response.json();
	}).then(data => {
		console.log(data);
		const html = 
		`<div>
		<p>sdf</p>
		</div>
		`
		
		console.log(html);
		document.querySelector('#app').insertAdjacentHTML('afterbegin', html)
	}).catch(error => {
		console.log(error);
	});

}

fetchData();