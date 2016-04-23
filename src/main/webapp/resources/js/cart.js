/**
 * Created by grigacs on 4/17/2016.
 */
$(document).ready(function () {

    var numProductsInCart = document.getElementById("cartSize").innerHTML;
    if (numProductsInCart != "0") {
        document.getElementById("cartSize").style.color = "rgb(52, 73, 94)";
    }

    $(".addCart").click(function () {
        document.getElementById("cartSize").style.color = "rgb(52, 73, 94)";
    });


    jsf.ajax.addOnEvent(foo);


    function foo(data) {
        var ajaxStatus = data.status; // Can be "begin", "complete" and "success".

        switch (ajaxStatus) {
            case "begin": // Right before sending ajax request.
                break;

            case "complete": // Right after receiving ajax response.
                break;

            case "success": // When ajax response is successfully processed.
                document.getElementById("cartSize").style.color = "rgb(52, 73, 94)";
                inputValue = [];
                var numItems = $('.qInput').length;
                for(var i=0;i<numItems;i++) {
                    inputValue.push(document.getElementsByClassName("qInput")[i].value);
                }
                break;
        }
    }


    var numItems = $('.qInput').length;

    var inputValue = [];

    for(var i=0;i<numItems;i++){
        inputValue.push(document.getElementsByClassName("qInput")[i].value);
    }



    $('#falsePress').keypress(function (e) {
        if (e.keyCode == '13') {
            e.preventDefault();
            //your code here
            for(var i=0;i<numItems;i++) {
                document.getElementsByClassName("qInput")[i].value = inputValue[i];
                console.log(inputValue)
            }
        }
    })

    var number = false;

        $(".edit").click(function () {
            var convert;
            for(var i=0;i<numItems;i++) {
                convert = document.getElementsByClassName("qInput")[i].value;
                if (!isNaN(convert)) {
                    console.log(typeof(convert));
                    console.log(!isNaN(convert));
                    number = true;
                }
            }

            if(number == true) {
                $(".edited").fadeIn(1000);
                setTimeout(function () {
                    $(".edited").fadeOut(1000, function () {
                    });
                }, 1500);
                number = false;
            }else{
                alert("only numbers");
                for(var i=0;i<numItems;i++) {
                    document.getElementsByClassName("qInput")[i].value = inputValue[i];
                    console.log(inputValue)
                }
            }
        });
});



