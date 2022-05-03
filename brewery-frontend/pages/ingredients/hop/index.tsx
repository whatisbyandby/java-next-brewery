import axios from 'axios';
import IngredientTopbar from '../../../components/IngredientTopbar';
import Page from '../../../components/Page';
import HopGrid from '../../../components/HopGrid';
import { SWRConfig } from 'swr';

export async function getServerSideProps({ params }: { params: any }) {
  const res = await axios.get(`http://localhost:8080/api/1.0/inventory/hop`);

  return {
    props: {
      fallback: {
        '/api/1.0/inventory/hop': res.data,
      },
    },
  };
}

export default function HopOverview({ fallback }: { fallback: any }) {
  return (
    <SWRConfig value={{ fallback }}>
      <IngredientTopbar />
      <HopGrid />
    </SWRConfig>
  );
}
