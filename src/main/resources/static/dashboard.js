
const BASE_URL = "http://localhost:8080/api/dashboard";
const SELECTED_MONTH = 1; 


let pieChartInstance = null;
let barChartInstance = null;


window.onload = function () {
    loadDashboardData();
};


function loadDashboardData() {
    fetch(`${BASE_URL}?month=${SELECTED_MONTH}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch dashboard data");
            }
            return response.json();
        })
        .then(data => {
            updateSummaryCards(data);
            renderPieChart(data.categoryExpenses);
            renderBarChart(data.monthlyExpenses);
        })
        .catch(error => {
            console.error("Dashboard error:", error);
        });
}


function updateSummaryCards(data) {
    document.getElementById("income").innerText =
        "₹" + data.totalIncome;

    document.getElementById("expense").innerText =
        "₹" + data.totalExpense;

    document.getElementById("savings").innerText =
        "₹" + data.savings;
}


function renderPieChart(categoryData) {

    const labels = Object.keys(categoryData);
    const values = Object.values(categoryData);

    
    if (pieChartInstance) {
        pieChartInstance.destroy();
    }

    pieChartInstance = new Chart(
        document.getElementById("pieChart"),
        {
            type: "pie",
            data: {
                labels: labels,
                datasets: [{
                    data: values,
                    backgroundColor: [
                        "#ff6384",
                        "#36a2eb",
                        "#ffce56",
                        "#4bc0c0",
                        "#9966ff"
                    ]
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                layout: {
                    padding: 10
                },
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                plugins: {
                    legend: {
                        position: "top"
                    }
                }
            }
        }
    );
}


function renderBarChart(monthlyData) {

    const labels = Object.keys(monthlyData);
    const values = Object.values(monthlyData);

    if (barChartInstance) {
        barChartInstance.destroy();
    }

    barChartInstance = new Chart(
        document.getElementById("barChart"),
        {
            type: "bar",
            data: {
                labels: labels,
                datasets: [{
                    label: "Expenses",
                    data: values,
                    backgroundColor: "#4bc0c0"
                }]
            },
            options: {
                responsive: true,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        }
    );
}
