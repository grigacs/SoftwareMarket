/**
 * Created by grigacs on 4/7/2016.
 */
var timer;
$(document).ready(function () {
    $("#slide > div:gt(0)").hide();


    timer = setInterval(function () {
        $('#slide > div:first')
            .fadeOut(2000)
            .next()
            .fadeIn(2000)
            .end()
            .appendTo('#slide');
    }, 7000);
});