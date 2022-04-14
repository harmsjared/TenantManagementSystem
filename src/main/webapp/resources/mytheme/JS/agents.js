

function callRandomUserApi() {
    var queryURL = "https://randomuser.me/api/?results=10&nat=us&exc=login";
    $.ajax({
        url: queryURL,
        method: "GET",
        success: function (data) {
            if (data.Response === "False") {
                console.log(data.Response)
            } else {
                console.log(data);
                renderResults(data);
            }
        },
        error: function (info) {
            console.log(info);
        },
    });
}

function renderResults(response){

    console.log(response.results);

    var results = response.results;

    for(var i = 0; i < results.length; i++){
        var photo = results[i].picture.medium;
        var firstN = results[i].name.first;
        var lastN = results[i].name.last;
        var streetNumber = results[i].location.street.number;
        var streetName = results[i].location.street.name;
        var city = results[i].location.city;
        var state = results[i].location.state;
        var phone = results[i].phone;

        var rowHTML = `<tr>
        <td><img src="${photo}" alt="Dr.${firstN} ${lastN}"></td>
        <td>${firstN} ${lastN}</td>
        <td>${streetNumber} ${streetName}</td>
        <td>${city}</td>
        <td>${state}</td>
        <td>${phone}</td>
      </tr>`

        $(".table_content").append(rowHTML);

    }

}
$(document).ready(callRandomUserApi());