/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const federation = document.getElementById("fed");
federation.addEventListener("click", function (evt) {
    const opt = document.getElementById("opt");
    opt.value = "1";
});

const competition = document.getElementById("comp");
competition.addEventListener("click", function (evt) {
    const opt = document.getElementById("opt");
    opt.value = "2";
});


