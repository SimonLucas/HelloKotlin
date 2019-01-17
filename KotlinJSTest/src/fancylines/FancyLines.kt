/*
This example is based on example from html5 canvas2D docs:
  http://www.w3.org/TR/2dcontext/
Note that only a subset of the api is supported for now.
*/

package fancylines


import jquery.*
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement

import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Math

fun main(args: Array<String>) {
    jq {
        // FancyLines().run()
        HelloWorld().run()
    }
}

val canvas = initalizeCanvas()
fun initalizeCanvas(): HTMLCanvasElement {
    val canvas = document.createElement("canvas") as HTMLCanvasElement
    val context = canvas.getContext("2d") as CanvasRenderingContext2D
    context.canvas.width = 600; // window.innerWidth / 3;
    context.canvas.height = 400; // window.innerHeight / 3;

    document.body!!.appendChild(canvas)
    return canvas
}

class HelloWorld() {
    val context = canvas.getContext("2d") as CanvasRenderingContext2D
    val height = canvas.height
    val width = canvas.width

    val square = width / 5.0

    var hue = 0.0
    var hueInc = 1

    fun testRect() {
        var x = (width-square) * Math.random();
        var y = (height-square) * Math.random();

        context.fillStyle = "hsl($hue, 50%, 50%)";
        hue += hueInc
        if (hue > 255) hue = 0.0
        // context.fillRect(0.0, 0.0, width.toDouble(), height.toDouble());
        context.fillRect(x, y, square, square);

    }

    fun blank() {
        context.fillStyle = "rgba(255,255,1,0.1)";
        context.fillRect(0.0, 0.0, width.toDouble(), height.toDouble());
    }



    fun run() {
        window.setInterval({ testRect() }, 20);
        window.setInterval({ blank() }, 100);

    }
}

class FancyLines() {
    val context = canvas.getContext("2d") as CanvasRenderingContext2D
    val height = canvas.height
    val width = canvas.width
    var x = width * Math.random()
    var y = height * Math.random()
    var hue = 0;

    fun line() {
        context.save();

        context.beginPath();

        context.lineWidth = 20.0 * Math.random();
        context.moveTo(x, y);

        x = width * Math.random();
        y = height * Math.random();

        context.bezierCurveTo(width * Math.random(), height * Math.random(),
                width * Math.random(), height * Math.random(), x, y);

        hue += (Math.random() * 10).toInt();

        context.strokeStyle = "hsl($hue, 50%, 50%)";

        context.shadowColor = "white";
        context.shadowBlur = 10.0;

        context.stroke();

        context.restore();
    }

    fun blank() {
        context.fillStyle = "rgba(255,255,1,0.1)";
        context.fillRect(0.0, 0.0, width.toDouble(), height.toDouble());
    }

    fun message() {
        context.fillStyle = "rgba(255,0,1,0.5)";
        val mess = mytest.Message().randomMessage()
        context.strokeText(mess, 20.0, 30.0)
    }

    fun run() {
        window.setInterval({ line() }, 40);
        window.setInterval({ blank() }, 100);
        window.setInterval({ message() }, 200);
    }
}
