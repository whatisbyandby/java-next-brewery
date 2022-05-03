import { Fermentable } from '../types';
import axios from 'axios';
import useSWR, { useSWRConfig } from 'swr';
import { useRouter } from 'next/router';
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

function TableRow({ fermentable }: { fermentable: Fermentable }) {
  const router = useRouter();
  const { mutate } = useSWRConfig();

  async function deleteFermentable(id: number) {
    if (confirm('Are you sure you want to delete this fermentable?')) {
      await axios.delete(`/api/1.0/inventory/fermentable/${id}`);
      mutate('/api/1.0/inventory/fermentable');
    }
  }

  return (
    <Tr>
      <Td>{fermentable.id}</Td>
      <Td>{fermentable.name}</Td>
      <Td>{fermentable.fermentableType}</Td>
      <Td>{fermentable.supplier}</Td>
      <Td>{fermentable.origin}</Td>
      <Td>
        <HStack spacing={2}>
          <Button
            onClick={() =>
              router.push(`/ingredients/fermentable/${fermentable.id}`)
            }
          >
            <BsPencilSquare />
          </Button>
          <Button onClick={() => deleteFermentable(fermentable.id)}>
            <BsTrashFill />
          </Button>
        </HStack>
      </Td>
    </Tr>
  );
}

export default function FermentableGrid() {
  const { data } = useSWR('/api/1.0/inventory/fermentable', () => {
    return axios.get('/api/1.0/inventory/fermentable').then((res) => res.data);
  });

  const router = useRouter();

  return (
    <>
      <TableContainer>
        <HStack spacing={2} m={2}>
          <Button
            colorScheme="blue"
            onClick={() => router.push('/ingredients/fermentable/new')}
          >
            New
          </Button>
        </HStack>
        <Table variant="simple">
          <Thead>
            <Tr>
              <Th>Id</Th>
              <Th>Fermentable</Th>
              <Th>Type</Th>
              <Th>Supplier</Th>
              <Th>Origin</Th>
              <Th></Th>
            </Tr>
          </Thead>
          <Tbody>
            {data.map((fermentable: Fermentable) => (
              <TableRow key={fermentable.id} fermentable={fermentable} />
            ))}
          </Tbody>
        </Table>
      </TableContainer>
    </>
  );
}
