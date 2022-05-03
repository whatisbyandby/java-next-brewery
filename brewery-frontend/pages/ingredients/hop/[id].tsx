import { Container } from '@chakra-ui/react';
import HopForm from '../../../components/HopForm';
import Page from '../../../components/Page';
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
    `http://localhost:8080/api/1.0/inventory/hop/${id}`
  );
  const hop = res.data;

  const key = `/api/1.0/inventory/hop/${id}`;

  return {
    props: {
      fallback: {
        [key]: hop,
      },
    },
  };
}

function EditHopForm({ id }: { id: string }) {
  const { data } = useSWR('/api/1.0/inventory/hop/' + id, () => {
    return axios.get('/api/1.0/inventory/hop/' + id).then((res) => res.data);
  });

  return (
    <Container maxW={'100%'} padding={2}>
      <HopForm hop={data} />
    </Container>
  );
}

export default function EditHop({ fallback }: { fallback: any }) {
  const router = useRouter();
  const { id } = router.query;

  return (
    <SWRConfig value={{ fallback }}>
      <EditHopForm id={id as string} />
    </SWRConfig>
  );
}
