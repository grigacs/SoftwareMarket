/**
 * Created by grigacs on 4/7/2016.
 */
var timer;
var timer2;
$(document).ready(function () {
    $("#slideshow > div:gt(0)").hide();



    timer = setInterval(function () {
        $('#slideshow > div:first')
            .fadeOut(2000)
            .next()
            .fadeIn(2000)
            .end()
            .appendTo('#slideshow');
    }, 10000);

    if($('#slideshow > div:first').css('opacity') == 1) {
    }else{
        $('#slideshow > div:first > h1:first').hide();
    }

    var imageHeight = $( ".sizeGallery" ).height();
    $( "#slideshow" ).height(imageHeight);

});

$( window ).resize(function() {
    var imageHeight = $( ".sizeGallery" ).height();
    $( "#slideshow" ).height(imageHeight);
});

$(document).load(function () {

    var size = $(window).width();
    var currentHeight = Math.floor(size / 4.465);

    var imageHeight = $( ".sizeGallery" ).height();
    $("#slideshow").height(currentHeight);
});
