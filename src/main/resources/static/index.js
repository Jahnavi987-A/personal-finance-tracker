function addTransaction(){
    const category = document.getElementById("category").value;
    const id = document.getElementById("id").value;
    const type = document.getElementById("type").value;
    const amount = document.getElementById("amount").value;
    const date = document.getElementById("date").value;


    fetch("http://localhost:8080/transactions",{
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id : id,
            type : type,
            date : date,
            category: category,
            amount: amount
        })
    }).then(res=>{
        if(res.ok){
            alert("Transaction is added");
        }else{
            alert("Something went wrong");
        }
    });
}
function getTransactions(){
    fetch("http://localhost:8080/transactions",{
        method: "GET"
    }).then(res=>res.json()).then(data=>{
        let text = "";
        data.forEach(txt => {
            text += txt.type+" ";
            text += txt.amount+" ";
            text += txt.category+" ";
            text += txt.date;
        });
        document.getElementById("output").value = text;
    });
}
function findById(){
    const id = document.getElementById("id").value;
    fetch("http://localhost:8080/transactions/"+id,{
        method: "GET"
    }).then(res=>res.json()).then(data=>{
        let text = "";
            text += data.type+" ";
            text += data.amount+" ";
            text += data.category+" ";
            text += data.date;
        document.getElementById("output").value = text;
        
    });
}
function deleteTransaction(){
    const id = document.getElementById("id").value;
    fetch("http://localhost:8080/deletetransactions/"+id,{
        method: "DELETE"
    }).then(res=>{
        if(res.ok){
            alert("Transaction is deleted");
        }else{
            alert("Transaction is not deleted");
        }
    })
}
function updateAll(){
    const category = document.getElementById("category").value;
    const id = document.getElementById("id").value;
    const type = document.getElementById("type").value;
    const amount = document.getElementById("amount").value;
    const date = document.getElementById("date").value;
    fetch("http://localhost:8080/updatealltransactions/"+id,{
        method: "PUT",
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify({
            type : type,
            date : date,
            category: category,
            amount: amount
        })
    }).then(res=>{
        if(res.ok){
            alert("Transaction is updated");
        }else{
            alert("Something went wrong");
        }
    });
}
function partialUpdate(){
    const category = document.getElementById("category").value;
    const id = document.getElementById("id").value;
    const type = document.getElementById("type").value;
    const amount = document.getElementById("amount").value;
    const date = document.getElementById("date").value;
    const patchData = {};
    if(category !== ""){
        patchData.category =category
    }
    if(type !== ""){
        patchData.type =type
    }
    if(date !== ""){
        patchData.date =date
    }
    if(amount !== ""){
        patchData.amount =amount
    }
    fetch("http://localhost:8080/updatetransactions/"+id,{
        method: "PATCH",
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(patchData) 
    }).then(res=>{
        if(res.ok){
            alert("Updation is done");
        }else{
            alert("Something went wrong");
        }
    }) 
}