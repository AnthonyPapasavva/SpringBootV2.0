let nav = 0;
let clicked = null;
let appointments = localStorage.getItem('appointments') ? JSON.parse(localStorage.getItem('appointments')) : [];

const calendar = document.getElementById('calendar');
const weekdays = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

const newAppointmentModal = document.getElementById('newAppointmentModal');
const deleteAppointmentModal = document.getElementById('deleteAppointmentModal');

const backDrop = document.getElementById('modalBackDrop');
const appointmentTitleInput = document.getElementById('appointmentTitleInput');
const appointmentItemInput = document.getElementById('appointmentItemInput');
const appointmentCompleteInput = document.getElementById('appointmentCompleteInput');

const editToDoId = document.getElementById('appointmentToDoIdUpdate');
const appointmentCompleteUpdate = document.getElementById('appointmentCompleteUpdate');
const appointmentTitleUpdate = document.getElementById('appointmentTitleUpdate');
const appointmentItemUpdate = document.getElementById('appointmentItemUpdate');

const appointmentToDoIdDelete = document.getElementById('appointmentToDoIdDelete');
// Frontend works however changes need to be made so that we can use fetchapis to link
// Frontend works however changes need to be made so that we can use fetchapis to link front and back end (may have to delete functionality here to meet spec :'( )

// insert the data at the same time its generated in the function planner

const toDoURL = "http://localhost:8085/todo"
const personURL = "http://localhost:8085/person"

const createToDo = () => {
    const appointmentTitleCreate = appointmentTitleInput.value;
    const appointmentItemCreate = appointmentItemInput.value;
    const appointmentCompleteCreate = appointmentCompleteInput.value;

    let toDoTitleObject = {
        "toDoTitle": appointmentTitleCreate,
        "toDoItem": appointmentItemCreate,
        "toDoComplete": appointmentCompleteCreate
    }

    fetch(`${toDoURL}/createToDo`, {
        method: "POST",
        body: JSON.stringify(toDoTitleObject),
        headers: {
            "Content-Type": "application/json"
        }
        })
        .then(response => response.json()).then(model => {console.log(model);
        readToDo();
        })
        .catch(err => console.error(`error ${err}`));

}

const readToDo = () => {
    fetch(`${toDoURL}/read`).then(function (response) {
        return response.json();
    })
    .then(function (data) {
        appendData(data);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });
        function appendData(toDoTitleObject) {
            var ToDoContainer = document.getElementById("ReadToDo");
            ToDoContainer.textContent = '';
            for (var i = 0; i < toDoTitleObject.length; i++) {
                var div = document.createElement("div");
                div.innerHTML = 'To Do Title: ' + toDoTitleObject[i].toDoTitle  + ' To Do Item: ' + toDoTitleObject[i].toDoItem + ' To Do Complete: ' + toDoTitleObject[i].toDoComplete;
                ToDoContainer.appendChild(div);
                }
                };

}

// Need to print Ids for read function

const updateToDo = (toDoId, completed) => {
    const editToDoIdW = editToDoId.value;
    const appointmentCompleteUpdateW = appointmentCompleteUpdate.value;

    let toDoTitleObject = {
        "toDoIdChange": editToDoIdW,
        "toDoTitle": "completed",
        "toDoItem": "completed",
        "toDoComplete": appointmentCompleteUpdateW
    }

    fetch(`${toDoURL}/updateToDo/${editToDoIdW}`, {
        method: "PUT",
        body: JSON.stringify(toDoTitleObject),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json()).then(model => {
            console.log(model);
            readToDo();
        })
        .catch(err => console.error(`error ${err}`));
}

const deleteToDo = () => {
    const appointmentToDoIdDeleteW = appointmentToDoIdDelete.value;

    fetch(`${toDoURL}/deleteToDo/${appointmentToDoIdDeleteW}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => console.log(response)).then(() => { readToDo();
        })
        .catch(err => console.error(`error ${err}`));
}

function planner() {
    const date = new Date();

    if (nav !== 0){
        date.setMonth(new Date().getMonth() + nav);
    }

    const day = date.getDate();
    const month = date.getMonth();
    const year = date.getFullYear();

    const firstDayOfMonth = new Date(year, month, 1);
    const daysInMonth = new Date(year, month + 1, 0).getDate();

    const dateString = firstDayOfMonth.toLocaleDateString('us-en', {
        weekday: 'long',
        day: 'numeric',
        month: 'numeric',
        year: 'numeric',
    });
    const paddingDays = weekdays.indexOf(dateString.split(', ')[0]);

    document.getElementById('monthDisplay').innerText = `${date.toLocaleDateString('us-en', {month: 'long'})} ${year}`;

    // In order to clear out auto generating calendar divs we gotta wipe with an empty String: 
    calendar.innerHTML = '';

    for(let i = 1; i <= paddingDays + daysInMonth; i++){
        const dayBox = document.createElement('div');
        const dayBoxText = `${i - paddingDays}/${month + 1}/${year}`;
        dayBox.classList.add('day');

        if (i > paddingDays){
            dayBox.innerText = i - paddingDays;

            const appointmentForDay = appointments.find(e => e.date === dayBoxText);

            if (i - paddingDays === day && nav === 0) {
                dayBox.id = 'currentDay';
            }

            if(appointmentForDay){
                const appointmentExists = document.createElement('exists');
                appointmentExists.classList.add('appointment');
                appointmentExists.innerText = appointmentForDay.title;
                dayBox.appendChild(appointmentExists);
            }

            dayBox.addEventListener('click', () => openModal(dayBoxText));

        } else {
            dayBox.classList.add('padding');
        }
        calendar.appendChild(dayBox);
    }
}

function buttons(){
    document.getElementById('previousButton').addEventListener('click', () => {
        nav--;
        planner();
    });
    document.getElementById('nextButton').addEventListener('click', () => {
        nav++;
        planner();
    });

    // document.getElementById('saveButton').addEventListener('click', createToDo);
    document.getElementById('cancelButton').addEventListener('click', closeModal);
    document.getElementById('deleteButton').addEventListener('click', deleteAppointment);
    document.getElementById('closeButton').addEventListener('click', closeModal);
}

function openModal(date){
    clicked = date;
    const appointmentForDay = appointments.find(e => e.date === clicked);

    if(appointmentForDay){
        document.getElementById('appointmentText').innerText = appointmentForDay.title;
        deleteAppointmentModal.style.display = 'block';
        // console.log('Appointment already exists');

    } else {
        newAppointmentModal.style.display = 'block';
    }
    
    backDrop.style.display = 'block';
}

function closeModal(){
    appointmentTitleInput.classList.remove('error');
    newAppointmentModal.style.display = 'none';
    deleteAppointmentModal.style.display = 'none';
    backDrop.style.display = 'none';
    appointmentTitleInput.value = '';
    clicked = null;

}

//change functions to not diaplsy info insetad to send info and then run read all 


// function saveAppointment(){
//     if (appointmentTitleInput.value) {
//         appointmentTitleInput.classList.remove('error');

//         appointments.push({
//             date: clicked,
//             title: appointmentTitleInput.value,
//         });

//         localStorage.setItem('appointments', JSON.stringify(appointments));
//         closeModal();

//     } else {
//         appointmentTitleInput.classList.add('error');
//     }
// }

function deleteAppointment(){
    appointments = appointments.filter(e => e.date !== clicked);
    localStorage.setItem('appointments', JSON.stringify(appointments)); 
    closeModal();
}

planner();
buttons();