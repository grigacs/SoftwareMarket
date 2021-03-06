$(document).ready(function () {

    if (document.getElementById("cartSize") != null) {
        var numProductsInCart = document.getElementById("cartSize").innerHTML;
        if (numProductsInCart != "0") {
            document.getElementById("cartSize").style.color = "rgb(52, 73, 94)";
        }
    }

});

function customExtender() {
    this.cfg.grid = {
        drawGridLines: true,        // wether to draw lines across the grid or not.
        gridLineColor: '#efeff1',    // *Color of the grid lines.
        background: '#ffffff',      // CSS color spec for background color of grid.
        borderColor: '#efeff1',     // CSS color spec for border around grid.
        borderWidth: 2.0,           // pixel width of border around grid.
        shadow: true,               // draw a shadow for grid.
        shadowAngle: 45,            // angle of the shadow.  Clockwise from x axis.
        shadowOffset: 1.5,          // offset from the line of the shadow.
        shadowWidth: 0,             // width of the stroke for the shadow.
        shadowDepth: 0,             // Number of strokes to make when drawing shadow.
                                    // Each stroke offset by shadowOffset from the last.
        shadowAlpha: 0.07,           // Opacity of the shadow
        renderer: $.jqplot.CanvasGridRenderer,  // renderer to use to draw the grid.
        rendererOptions: {}         // options to pass to the renderer.  Note, the default
    }
}