// app.js

document.getElementById("fetchQuestionsBtn").addEventListener("click", fetchQuestions);

async function fetchQuestions() {
    try {
        const response = await fetch("http://localhost:8080/api/questionbank/random5");
        if (!response.ok) throw new Error("Network response was not ok");

        const questions = await response.json();
        displayQuestions(questions);
    } catch (error) {
        console.error("Error fetching questions:", error);
        alert("Failed to fetch questions. Check console for details.");
    }
}

function displayQuestions(questions) {
    console.log("displayQuestions function started");
    const container = document.getElementById("questionsContainer");
    container.innerHTML = ""; // Clear previous content

    questions.forEach((question, index) => {
        const questionDiv = document.createElement("div");
        questionDiv.classList.add("question");

        const questionText = document.createElement("h3");
        questionText.innerText = `Q${index + 1}: ${question.questionText}`;
        questionDiv.appendChild(questionText);

        const optionsList = document.createElement("ul");
        optionsList.classList.add("options");

        question.options.forEach((option, i) => {
            const optionItem = document.createElement("li");
            optionItem.innerText = `${String.fromCharCode(65 + i)}. ${option}`;
            optionsList.appendChild(optionItem);
        });

        questionDiv.appendChild(optionsList);

        const explanation = document.createElement("p");
        explanation.classList.add("explanation");
        explanation.innerText = `Explanation: ${question.explain}`;
        questionDiv.appendChild(explanation);

        container.appendChild(questionDiv);
    });
}
