
function validateWinner(){
    let vertical = verticalValidation();
    let horizontal = horizontalValidation();
    let diagonalR = digonalRightValidation();
    let diagonalL = digonalLeftValidation();
    let corners = cornerValidation();

    if(vertical || horizontal || diagonalR || diagonalL || corners){

        let idWinner = document.getElementById("username").innerHTML
        
        axios.post('http://localhost:9090/setwinner',idWinner).then(resp => {
            console.log('idWinner ' + idWinner);
            location.replace("http://localhost:3000/winner?"+idWinner);
        });
        }

       

    }

function verticalValidation (){
    let winner = false;
    let sizeTrArray = document.getElementsByTagName("tr").length;
    let sizeTdArray =document.getElementsByTagName("tr")[0].children.length;
    for(let j = 0; j < sizeTdArray; j++ ){
        let count = 0;
        for(let i = 1 ; i < sizeTrArray; i++ ){
            let data = document.getElementsByTagName("tr")[i].children[j].getAttribute("style","background-color");
            if(data != null){
                count += 1;
            } 
        }
        if(count == 5){
            winner = true;
            console.log('winner')
        } 
    }
   return winner;
}

function horizontalValidation (){
    let winner = false;
    let sizeTrArray = document.getElementsByTagName("tr").length;
    let sizeTdArray =document.getElementsByTagName("tr")[0].children.length;
    for(let j = 1; j < sizeTrArray; j++ ){
        let count = 0;
        for(let i = 0 ; i < sizeTdArray; i++ ){
            let data = document.getElementsByTagName("tr")[j].children[i].getAttribute("style","background-color");
            if(data != null){
                count += 1;
            } 
        }
        if(count == 5){
            winner = true;
            console.log('winner')
        } 
    }
   return winner;
}

function digonalRightValidation (){
    let winner = false;
    let sizeTrArray = document.getElementsByTagName("tr").length;
      
        let count = 0;
        for(let i = 1 ; i < sizeTrArray; i++ ){
            let data = document.getElementsByTagName("tr")[i].children[i-1].getAttribute("style","background-color");
            if(data != null){
                count += 1;
            } 
        }
        if(count == 5){
            winner = true;
            console.log('winner')
        } 
    return winner;
}

function digonalLeftValidation (){
    let winner = false;
    let sizeTrArray = document.getElementsByTagName("tr").length;
     
        let count = 0;
        let j = 0;
        for(let i = sizeTrArray ; i > 1; i-- ){
            let data = document.getElementsByTagName("tr")[i-1].children[j].getAttribute("style","background-color");
            if(data != null){
                count += 1;
            } 
            j += 1;
        }
        if(count == 5){
            winner = true;
            console.log('winner')
        } 
    return winner;
}

function cornerValidation (){
    let winner = false;

    let data1 = document.getElementsByTagName("tr")[1].children[0].getAttribute("style","background-color");
    let data2 = document.getElementsByTagName("tr")[5].children[0].getAttribute("style","background-color");
    let data3 = document.getElementsByTagName("tr")[1].children[4].getAttribute("style","background-color");
    let data4 = document.getElementsByTagName("tr")[5].children[4].getAttribute("style","background-color");

        if(data1 != null && data2 != null && data3 != null && data4 != null){
            winner = true;
            console.log('winner')
        } 
    return winner;
}


    
