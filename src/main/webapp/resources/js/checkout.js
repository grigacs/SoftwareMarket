/**
 * Created by grigacs on 4/17/2016.
 */
$(document).ready(function () {
    $(".checkOut").click(function () {
        $(".overlay").show();
        $("#successCheck").hide();

    });

    $(".close").click(function () {
        $(".overlay").hide();
        window.location.href = "products.xhtml";
        setTimeout(function () {
            $("#successCheck").show();
        }, 2000);
    });


    $(".icon-cart").click(function () {
        $(".popup2").fadeIn(1000);
        setTimeout(function () {
            $(".popup2").fadeOut(1000, function () {
                // Animation complete.
            });
        }, 1500);
    });

    if (document.getElementById("cartSize") != null) {
        var numProductsInCart = document.getElementById("cartSize").innerHTML;
        if (numProductsInCart != "0") {
            document.getElementById("cartSize").style.color = "rgb(52, 73, 94)";
        }
    }
});



