window.onload = function() {
    examplePostingARecord();
    getAllRecords();
};

function examplePostingARecord()
{
    //create a Javascript object for a new product
    let product = {
        name: "Ice Cream Bowl",
        price: 11.99,
        category: "Misc",
        details: "A bowl for your ice cream"
    };

    let uri = "http://localhost:8080/products";
    let config = {
        method: "POST",
        mode: "cors",
        headers: {
            "Content-Type": "application/json"
        },
        //we need to convert a JS object to JSON here...
        body: JSON.stringify(product)
    };

    //show the data on the page
    fetch(uri, config)
        .then((response) => {
            console.log("Http status code: " + response.status);
            console.log(response.headers);
            console.log(response.body);
            return response.json();
        })
        .then((json) => {
            console.log(json);
        });
}

function getAllRecords()
{
    //read data from the web api at http://localhost:8080
    let uri = "http://localhost:8080/products";
    let config = {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json"
        }
    };

    //show the data on the page
    fetch(uri, config)
        .then((response) => {
            console.log("Http status code: " + response.status);
            console.log(response.headers);
            console.log(response.body);
            return response.json();
        })
        .then((json) => {
            displaysDataElements(json);
        });

    console.log("all done");
}

function displaysDataElements(jsonData)
{
    console.log(jsonData);

    //select the area to put our data within
    let contentArea = document.getElementById("content");

    for (let i = 0; i < jsonData.length; i++)
    {
        addProductCard(contentArea, jsonData[i]);
    }
}

function addProductCard(contentArea, product)
{
    //create a new paragraph
    let card = document.createElement("div");
    let name = document.createElement("p");
    let price = document.createElement("p");
    let details = document.createElement("p");

    //assign data values
    name.innerHTML = product.name;
    price.innerHTML = "$" + product.price;
    details.innerHTML = product.details;

    //style the card
    card.className = "card";

    //assemble the card
    card.appendChild(name);
    card.appendChild(price);
    card.appendChild(details);

    //then add the card to the content area
    contentArea.appendChild(card);
}






