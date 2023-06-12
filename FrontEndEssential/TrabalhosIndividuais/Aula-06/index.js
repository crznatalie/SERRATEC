console.log("Inicio do JavaScript");

let dados;

async function getData() {
    dadosJson = await fetch ('https://api.thecatapi.com/v1/images/search?limit=10'); 
    let dados = await dadosJson.json();
    
    console.log("DADOSJSON: ", dadosJson);
    console.log("DADOS: ", dados);
    console.log("Link: ", dados[0].width);
    console.log("Tamanho do Array: ", dados.lenght);

    dados.forEach(item => {
        const li = document.createElement("li");
        li.innerText = item.url;
    });
}

getData();

console.log("Fim do JavaScript");