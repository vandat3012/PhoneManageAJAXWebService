function showList() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/smartphones",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `${getSmartphone(data[i])}`
            }
            document.getElementById("list").innerHTML = content;
        }
    })
}

showList();

function addNewSmartPhone() {
    event.preventDefault();
    let producer = document.getElementById("producer").value;
    let model = document.getElementById("model").value;
    let price = document.getElementById("price").value;

    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSmartphone),
        url: "http://localhost:8080/api/smartphones",
        success: showList
    });
}

function getSmartphone(smartphone) {
    return `<tr><td>${smartphone.id}</td><td >${smartphone.producer}</td><td >${smartphone.model}</td><td >${smartphone.price}</td>` +
        `<td class="btn"><button class="deleteSmartphone" onclick="deleteSmartPhone(${smartphone.id})">Delete</button></td></tr>`;
}

function deleteSmartPhone(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: showList
    })
}