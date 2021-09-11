import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/Navbar";

function App() {
  return (
    <>
      <NavBar/>
      <div className='bg-primary container'>
        <h1>ola</h1>
        <DataTable/>
      </div>
      <Footer/>
    </>
  );
}

export default App;
