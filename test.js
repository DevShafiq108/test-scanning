const express = require('express');
const bodyParser = require('body-parser');
const exec = require('child_process').exec;

const app = express();

// Vulnerability 1: Using a vulnerable version of Express
// Upgrade Express to the latest version to fix this vulnerability
// npm install express@latest

// Vulnerability 2: Using a vulnerable version of bodyParser
// Upgrade bodyParser to the latest version to fix this vulnerability
// npm install body-parser@latest

app.use(bodyParser.json());

// Vulnerability 3: Command Injection vulnerability
app.post('/execute', (req, res) => {
  const command = req.body.command;
  exec(command, (error, stdout, stderr) => {
    if (error) {
      console.error(`exec error: ${error}`);
      res.status(500).send(error.message);
      return;
    }
    console.log(`stdout: ${stdout}`);
    console.error(`stderr: ${stderr}`);
    res.send(stdout);
  });
});

// Vulnerability 4: XSS vulnerability
app.get('/search', (req, res) => {
  const searchTerm = req.query.q;
  res.send(`<h1>Search results for: ${searchTerm}</h1>`);
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
