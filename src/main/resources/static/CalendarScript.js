let nav = 0;
let clicked = null;
let appointments = localStorage.getItem('appointments') ? JSON.parse(localStorage.getItem('appointments')) : [];

const calendar = document.getElementById('calendar');
const weekdays = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

const newAppointmentModal = document.getElementById('newAppointmentModal');
const deleteAppointmentModal = document.getElementById('deleteAppointmentModal');

const backDrop = document.getElementById('modalBackDrop');
const appointmentTitleInput = document.getElementById('appointmentTitleInput');

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
    planner();

}

function saveAppointment(){
    if (appointmentTitleInput.value) {
        appointmentTitleInput.classList.remove('error');

        appointments.push({
            date: clicked,
            title: appointmentTitleInput.value,
        });

        localStorage.setItem('appointments', JSON.stringify(appointments));
        closeModal();

    } else {
        appointmentTitleInput.classList.add('error');
    }
}

function deleteAppointment(){
    appointments = appointments.filter(e => e.date !== clicked);
    localStorage.setItem('appointments', JSON.stringify(appointments)); 
    closeModal();
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

    document.getElementById('homeButton').onclick = function (){
        location.href = "index.html";
    };

    document.getElementById('saveButton').addEventListener('click', saveAppointment);
    document.getElementById('cancelButton').addEventListener('click', closeModal);
    document.getElementById('deleteButton').addEventListener('click', deleteAppointment);
    document.getElementById('closeButton').addEventListener('click', closeModal);
}

planner();
buttons();
