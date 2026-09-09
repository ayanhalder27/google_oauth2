async function load(){
    const response = await fetch("http://localhost:8081/api/person?continue");

    const data = await response.json();

    document.querySelector(".title").textContent = data.name;
    document.querySelector(".email").textContent = data.email;
}

load()