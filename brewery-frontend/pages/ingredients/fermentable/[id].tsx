import { Container } from '@chakra-ui/react';
import FermentableForm from '../../../components/FermentableForm';
import Page from '../../../components/Page';
import useSWR, { SWRConfig } from 'swr';
import { useRouter } from 'next/router';
import axios from 'axios';

export async function getServerSideProps({ params }: { params: any }) {
  const res = await axios.get(
    `http://localhost:8080/api/1.0/inventory/fermentable/${params.id}`
  );
  const fermentable = res.data;

  const key = `/api/1.0/inventory/fermentable/${params.id}`;

  return {
    props: {
      fallback: {
        [key]: fermentable,
      },
    },
  };
}

function EditFermentableForm({ id }: { id: string }) {
  const { data } = useSWR(`/api/1.0/inventory/fermentable/${id}`, () => {
    return axios
      .get(`/api/1.0/inventory/fermentable/${id}`)
      .then((res) => res.data);
  });

  return (
    <Container maxW={'100%'} padding={2}>
      <FermentableForm fermentable={data} />
    </Container>
  );
}

export default function EditFermentable({ fallback }: { fallback: any }) {
  const router = useRouter();
  const { id } = router.query;

  return (
    <SWRConfig value={{ fallback }}>
      <EditFermentableForm id={id as string} />
    </SWRConfig>
  );
}
