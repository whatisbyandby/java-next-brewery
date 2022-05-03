import axios from 'axios';
import IngredientTopbar from '../../../components/IngredientTopbar';
import MiscGrid from '../../../components/MiscGrid';
import { SWRConfig } from 'swr';

export async function getServerSideProps({ params }: { params: any }) {
  const res = await axios.get(`http://localhost:8080/api/1.0/inventory/misc`);

  return {
    props: {
      fallback: {
        '/api/1.0/inventory/misc': res.data,
      },
    },
  };
}

export default function MiscOverview({ fallback }: { fallback: any }) {
  return (
    <SWRConfig value={{ fallback }}>
      <IngredientTopbar />
      <MiscGrid />
    </SWRConfig>
  );
}
