import axios from 'axios';
import IngredientTopbar from '../../../components/IngredientTopbar';
import Page from '../../../components/Page';
import YeastGrid from '../../../components/YeastGrid';
import { SWRConfig } from 'swr';

export async function getServerSideProps({ params }: { params: any }) {
  const res = await axios.get(`http://localhost:8080/api/1.0/inventory/yeast`);

  return {
    props: {
      fallback: {
        '/api/1.0/inventory/yeast': res.data,
      },
    },
  };
}

export default function HopOverview({ fallback }: { fallback: any }) {
  return (
    <SWRConfig value={{ fallback }}>
      <IngredientTopbar />
      <YeastGrid />
    </SWRConfig>
  );
}
