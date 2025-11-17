// SpeedTestService.js
const SpeedTestService = {
    startTest: async () => {
        try {
          const response = await fetch('http://localhost:8080/api/speedtest');
          if (!response.ok) throw new Error('Network response was not ok');
          return await response.json();
        } catch (error) {
          console.error('Error during speed test fetch:', error);
          return { download: 0, upload: 0, ping: 0 };
        }
      },
    };
  
  export default SpeedTestService;
  