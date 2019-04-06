function conutdown(x)
{
    var distance=x;
    var x = setInterval(function() {
    distance=distance-1;

    
  // Time calculations for days, hours, minutes and seconds
  var minutes = Math.floor((distance /60));
  var seconds = Math.floor((distance % 60));
    
  // Output the result in an element with id="demo"
  document.getElementById("demo").innerHTML =  minutes + "m " + seconds + "s ";
    
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("demo").innerHTML = "EXPIRED";
  }
}, 1000);

}