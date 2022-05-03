import { Yeast } from '../types';
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
  useDisclosure,
} from '@chakra-ui/react';
import { BsTrashFill, BsPencilSquare } from 'react-icons/bs';
import { useRouter } from 'next/router';

function TableRow({ yeast }: { yeast: Yeast }) {
  const router = useRouter();
  const { mutate } = useSWRConfig();

  async function deleteYeast(id: number) {
    if (confirm('Are you sure you want to delete this yeast?')) {
      await axios.delete(`/api/1.0/inventory/yeast/${id}`);
      mutate('/api/1.0/inventory/yeast');
    }
  }

  return (
    <Tr>
      <Td>{yeast.id}</Td>
      <Td>{yeast.name}</Td>
      <Td>{yeast.yeastType}</Td>
      <Td>{yeast.supplier}</Td>
      <Td>{yeast.origin}</Td>
      <Td>
        <HStack spacing={2}>
          <Button onClick={() => router.push(`/ingredients/yeast/${yeast.id}`)}>
            <BsPencilSquare />
          </Button>
          <Button onClick={() => deleteYeast(yeast.id)}>
            <BsTrashFill />
          </Button>
        </HStack>
      </Td>
    </Tr>
  );
}

export default function YeastGrid() {
  const { data } = useSWR('/api/1.0/inventory/yeast', () => {
    return axios.get('/api/1.0/inventory/yeast').then((res) => res.data);
  });

  const router = useRouter();

  return (
    <>
      <TableContainer>
        <HStack spacing={2} m={2}>
          <Button
            colorScheme="blue"
            onClick={() => router.push('/ingredients/yeast/new')}
          >
            New
          </Button>
        </HStack>
        <Table variant="simple">
          <Thead>
            <Tr>
              <Th>Id</Th>
              <Th>Yeast</Th>
              <Th>Type</Th>
              <Th>Supplier</Th>
              <Th>Origin</Th>
            </Tr>
          </Thead>
          <Tbody>
            {data.map((yeast: Yeast) => (
              <TableRow key={yeast.id} yeast={yeast} />
            ))}
          </Tbody>
        </Table>
      </TableContainer>
    </>
  );
}
