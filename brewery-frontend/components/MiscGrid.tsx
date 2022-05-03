import { Miscellaneous } from '../types';
import axios from 'axios';
import useSWR, { useSWRConfig } from 'swr';
import {
  TableContainer,
  Table,
  Thead,
  Tr,
  Th,
  Td,
  Tbody,
  HStack,
  Button,
} from '@chakra-ui/react';
import { BsTrashFill, BsPencilSquare } from 'react-icons/bs';
import { useRouter } from 'next/router';

function TableRow({ misc }: { misc: Miscellaneous }) {
  const router = useRouter();
  const { mutate } = useSWRConfig();

  async function deleteMisc(id: number) {
    if (confirm('Are you sure you want to delete this misc?')) {
      await axios.delete(`/api/1.0/inventory/misc/${id}`);
      mutate('/api/1.0/inventory/misc');
    }
  }

  return (
    <Tr>
      <Td>{misc.id}</Td>
      <Td>{misc.name}</Td>
      <Td>{misc.miscType}</Td>
      <Td>{misc.supplier}</Td>
      <Td>{misc.origin}</Td>
      <Td>
        <HStack spacing={2}>
          <Button
            onClick={() => router.push(`/ingredients/miscellaneous/${misc.id}`)}
          >
            <BsPencilSquare />
          </Button>
          <Button onClick={() => deleteMisc(misc.id)}>
            <BsTrashFill />
          </Button>
        </HStack>
      </Td>
    </Tr>
  );
}

export default function MiscGrid() {
  const { data } = useSWR('/api/1.0/inventory/misc', () => {
    return axios.get('/api/1.0/inventory/misc').then((res) => res.data);
  });

  const router = useRouter();

  return (
    <>
      <TableContainer>
        <HStack spacing={2} m={2}>
          <Button
            colorScheme="blue"
            onClick={() => router.push('/ingredients/miscellaneous/new')}
          >
            New
          </Button>
        </HStack>
        <Table variant="simple">
          <Thead>
            <Tr>
              <Th>Id</Th>
              <Th>Misc</Th>
              <Th>Type</Th>
              <Th>Supplier</Th>
              <Th>Origin</Th>
            </Tr>
          </Thead>
          <Tbody>
            {data.map((misc: Miscellaneous) => (
              <TableRow key={misc.id} misc={misc} />
            ))}
          </Tbody>
        </Table>
      </TableContainer>
    </>
  );
}
