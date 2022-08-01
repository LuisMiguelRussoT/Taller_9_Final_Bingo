/**
 * update information to show on the winner view
 */

let data = location.search.substring(1).replace('=','');
console.log('data :>> ', data);
let div = document.getElementById('winnerGG');
div.textContent = data;