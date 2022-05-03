import { Container } from '@chakra-ui/react';
import YeastForm from '../../../components/YeastForm';
import useSWR, { SWRConfig } from 'swr';
import { useRouter } from 'next/router';
import axios from 'axios';

export async function getServerSideProps({
  params,
}: {
  params: { id: string };
}) {
  const { id } = params;

  const res = await axios.get(
    `http://localhost:8080/api/1.0/inventory/yeast/${id}`
  );
  const yeast = res.data;

  const key = `/api/1.0/inventory/yeast/${id}`;

  return {
    props: {
      fallback: {
        [key]: yeast,
      },
    },
  };
}

function EditYeastForm({ id }: { id: string }) {
  const { data } = useSWR('/api/1.0/inventory/yeast/' + id, () => {
    return axios.get('/api/1.0/inventory/yeast/' + id).then((res) => res.data);
  });

  return (
    <Container maxW={'100%'} padding={2}>
      <YeastForm yeast={data} />
    </Container>
  );
}

export default function EditYeast({ fallback }: { fallback: any }) {
  const router = useRouter();
  const { id } = router.query;

  return (
    <SWRConfig value={{ fallback }}>
      <EditYeastForm id={id as string} />
    </SWRConfig>
  );
}
