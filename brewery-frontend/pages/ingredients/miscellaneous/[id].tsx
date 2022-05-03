import { Container } from '@chakra-ui/react';
import MiscForm from '../../../components/MiscForm';
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
    `http://localhost:8080/api/1.0/inventory/misc/${id}`
  );
  const misc = res.data;

  const key = `/api/1.0/inventory/misc/${id}`;

  return {
    props: {
      fallback: {
        [key]: misc,
      },
    },
  };
}

function EditMiscForm({ id }: { id: string }) {
  const { data } = useSWR('/api/1.0/inventory/misc/' + id, () => {
    return axios.get('/api/1.0/inventory/misc/' + id).then((res) => res.data);
  });

  return (
    <Container maxW={'100%'} padding={2}>
      <MiscForm misc={data} />
    </Container>
  );
}

export default function EditMisc({ fallback }: { fallback: any }) {
  const router = useRouter();
  const { id } = router.query;

  return (
    <SWRConfig value={{ fallback }}>
      <EditMiscForm id={id as string} />
    </SWRConfig>
  );
}
