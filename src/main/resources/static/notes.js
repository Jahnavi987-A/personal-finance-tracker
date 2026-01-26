function addNotes() {
    const id = document.getElementById("id1").value;
    const date = document.getElementById("date1").value;
    const note = document.getElementById("note").value;

    fetch("http://localhost:8080/notes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: id,
            date: date,
            notes: note
        })
    }).then(res => {
        if (res.ok) {
            alert("Notes is saved");
        } else {
            alert("Notes is not saved");
        }
    });
}
function deleteNotes() {
    const id = document.getElementById("id1").value;
    fetch("http://localhost:8080/deletenotes/" + id, {
        method: "DELETE",
    }).then(res => {
        if (res.ok) {
            alert("Notes is deleted");
        } else {
            alert("Notes is not Removed");
        }
    })
}
function updateNotes() {
    const id = document.getElementById("id1").value;
    const notes = document.getElementById("note").value;
    fetch("http://localhost:8080/updatenotes/" + id, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            notes: notes
        })
    }).then(res => {
        if (res.ok) {
            alert("Notes is updated successfully");
        } else {
            alert("Something went wrong");
        }
    })
}
function getNotes() {
    fetch("http://localhost:8080/getNotes/" , {
        method: "GET"
    }).then(res => res.json()).then(data => {
        let text = "";
        data.forEach(txt => {
            text += txt.notes + ", ";
                text += txt.date + "\n";
        });
        document.getElementById("output1").value = text;
    })
}