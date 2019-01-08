if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'KotlinJSTest'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'KotlinJSTest'.");
}
var KotlinJSTest = function (_, Kotlin) {
  'use strict';
  var Unit = Kotlin.kotlin.Unit;
  var throwCCE = Kotlin.throwCCE;
  var ensureNotNull = Kotlin.ensureNotNull;
  var numberToInt = Kotlin.numberToInt;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  function main$lambda() {
    (new FancyLines()).run();
    return Unit;
  }
  function main(args) {
    $(main$lambda);
  }
  var canvas;
  function initalizeCanvas() {
    var tmp$, tmp$_0;
    var canvas = Kotlin.isType(tmp$ = document.createElement('canvas'), HTMLCanvasElement) ? tmp$ : throwCCE();
    var context = Kotlin.isType(tmp$_0 = canvas.getContext('2d'), CanvasRenderingContext2D) ? tmp$_0 : throwCCE();
    context.canvas.width = 600;
    context.canvas.height = 200;
    ensureNotNull(document.body).appendChild(canvas);
    return canvas;
  }
  function FancyLines() {
    var tmp$;
    this.context = Kotlin.isType(tmp$ = canvas.getContext('2d'), CanvasRenderingContext2D) ? tmp$ : throwCCE();
    this.height = canvas.height;
    this.width = canvas.width;
    this.x = this.width * Math.random();
    this.y = this.height * Math.random();
    this.hue = 0;
  }
  FancyLines.prototype.line = function () {
    this.context.save();
    this.context.beginPath();
    this.context.lineWidth = 20.0 * Math.random();
    this.context.moveTo(this.x, this.y);
    this.x = this.width * Math.random();
    this.y = this.height * Math.random();
    this.context.bezierCurveTo(this.width * Math.random(), this.height * Math.random(), this.width * Math.random(), this.height * Math.random(), this.x, this.y);
    this.hue = this.hue + numberToInt(Math.random() * 10) | 0;
    this.context.strokeStyle = 'hsl(' + this.hue + ', 50%, 50%)';
    this.context.shadowColor = 'white';
    this.context.shadowBlur = 10.0;
    this.context.stroke();
    this.context.restore();
  };
  FancyLines.prototype.blank = function () {
    this.context.fillStyle = 'rgba(255,255,1,0.1)';
    this.context.fillRect(0.0, 0.0, this.width, this.height);
  };
  function FancyLines$run$lambda(this$FancyLines) {
    return function () {
      this$FancyLines.line();
      return Unit;
    };
  }
  function FancyLines$run$lambda_0(this$FancyLines) {
    return function () {
      this$FancyLines.blank();
      return Unit;
    };
  }
  FancyLines.prototype.run = function () {
    window.setInterval(FancyLines$run$lambda(this), 40);
    window.setInterval(FancyLines$run$lambda_0(this), 100);
  };
  FancyLines.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'FancyLines',
    interfaces: []
  };
  var package$fancylines = _.fancylines || (_.fancylines = {});
  package$fancylines.main_kand9s$ = main;
  Object.defineProperty(package$fancylines, 'canvas', {
    get: function () {
      return canvas;
    }
  });
  package$fancylines.initalizeCanvas = initalizeCanvas;
  package$fancylines.FancyLines = FancyLines;
  canvas = initalizeCanvas();
  main([]);
  Kotlin.defineModule('KotlinJSTest', _);
  return _;
}(typeof KotlinJSTest === 'undefined' ? {} : KotlinJSTest, kotlin);
