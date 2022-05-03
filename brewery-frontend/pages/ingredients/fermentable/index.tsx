import axios from 'axios';
import IngredientTopbar from '../../../components/IngredientTopbar';
import Page from '../../../components/Page';
import FermentableGrid from '../../../components/FermentableGrid';
import useSWR, { SWRConfig } from 'swr';

export async function getServerSideProps({ params }: { params: any }) {
  const res = await axios.get(
    `http://localhost:8080/api/1.0/inventory/fermentable`
  );

  return {
    props: {
      fallback: {
        '/api/1.0/inventory/fermentable': res.data,
      },
    },
  };
}

export default function FermentableOverview({ fallback }: { fallback: any }) {
  return (
    <SWRConfig value={{ fallback }}>
      <IngredientTopbar />
      <FermentableGrid />
    </SWRConfig>
  );
}
