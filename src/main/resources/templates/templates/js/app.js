function addTheme() {
    var theme = $("#themeName").val();
    var option1 = $("#option1").val();
    var option2 = $("#option2").val();

    var newTheme = {
        "themeName": theme,
        "options": [{"themeOption.name": option1, "quantity": 0}, {"themeOption.name": option2, "quantity": 0}]
    };
    $.ajax({
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(newTheme),
        url: "themes"
    });
}

function plusVote1() {
    var quant1 = $("#quantity1").val() + 1;
    var addVote = [{"theme.quantity1": quant1}];
    $.ajax({
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: addVote,
        url: "themes"
    });
}
function plusVote2() {
    var quant2 = $("#quantity2").val() + 1;
    var addVote = [{"theme.quantity1": quant2}];
    $.ajax({
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: addVote,
        url: "themes"
    });
}

