import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Main from "./Main";
import MetricsEdit from "./updateComponent/MetricsEdit";

const App = () => {
  return (
      <Router>
        <Routes>
          <Route path="/" element={<Main />} />
            <Route path="/metrics/edit/:id" element={<MetricsEdit />} />
        </Routes>
      </Router>
  );
};

export default App;