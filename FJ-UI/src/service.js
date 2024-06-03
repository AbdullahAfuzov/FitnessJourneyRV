const BASE_URL = 'http://localhost:8080';

const apiService = {

  getMetrics: async () => {
    const response = await fetch(`${BASE_URL}/getMetrics`);
    return response.json();
  },

  getMetricsById: async  (id) => {
    const response = await fetch(`${BASE_URL}/getMetrics/${id}`);
    return response.json();
  },

  addMetrics: async (metricsData) => {
    const response = await fetch(`${BASE_URL}/addMetrics`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(metricsData),
    });
    return response.json();
  },

  updateMetrics: async (id, metricsData) => {
    const response = await fetch(`${BASE_URL}/updateMetrics/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(metricsData),
    });
    return response.json();
  },

  deleteMetrics: async (id) => {
    const response = await fetch(`${BASE_URL}/deleteMetrics/${id}`, {
      method: 'DELETE',
    });
    return response.json;
  },

  getExUsers: async () => {
    const response = await fetch(`${BASE_URL}/getExUsers`);
    return response.json();
  },

  addExUser: async (exUsersData) => {
    const response = await fetch(`${BASE_URL}/addExUser`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(exUsersData),
    });
    return response.json();
  },

  deleteExUser: async (id) => {
    const response = await fetch(`${BASE_URL}/deleteExUser/${id}`, {
      method: 'DELETE',
    });
    return response.json;
  },

  getFoodUser: async () => {
    const response = await fetch(`${BASE_URL}/getFoodUsers`);
    return response.json();
  },

  addFoodUser: async (foodUsersData) => {
    const response = await fetch(`${BASE_URL}/addFoodUser`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(foodUsersData),
    });
    return response.json();
  },

  deleteFoodUser: async (id) => {
    const response = await fetch(`${BASE_URL}/deleteFoodUser/${id}`, {
      method: 'DELETE',
    });
    return response.json;
  },
};

export default apiService;
