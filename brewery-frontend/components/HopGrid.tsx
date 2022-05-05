import { Hop, HopType } from '../types';
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
import { FileUploader } from 'react-drag-drop-files';
import DragFileUploader from './DragFileUploader';

function TableRow({ hop }: { hop: Hop }) {
  const router = useRouter();
  const { mutate } = useSWRConfig();

  async function deleteHop(id: number) {
    if (confirm('Are you sure you want to delete this hop?')) {
      await axios.delete(`/api/1.0/inventory/hop/${id}`);
      mutate('/api/1.0/inventory/hop');
    }
  }

  return (
    <Tr>
      <Td>{hop.id}</Td>
      <Td>{hop.name}</Td>
      <Td>{hop.hopType}</Td>
      <Td>{hop.supplier}</Td>
      <Td>{hop.origin}</Td>
      <Td>
        <HStack spacing={2}>
          <Button onClick={() => router.push(`/ingredients/hop/${hop.id}`)}>
            <BsPencilSquare />
          </Button>
          <Button onClick={() => deleteHop(hop.id)}>
            <BsTrashFill />
          </Button>
        </HStack>
      </Td>
    </Tr>
  );
}

export default function HopGrid() {
  const { data } = useSWR('/api/1.0/inventory/hop', () => {
    return axios.get('/api/1.0/inventory/hop').then((res) => res.data);
  });

  const router = useRouter();

  return (
    <>
      <TableContainer>
        <HStack justify="space-between" m={2}>
          <Button
            colorScheme="blue"
            onClick={() => router.push('/ingredients/hop/new')}
          >
            New
          </Button>
          <DragFileUploader />
        </HStack>
        <Table variant="simple">
          <Thead>
            <Tr>
              <Th>Id</Th>
              <Th>Hop</Th>
              <Th>Type</Th>
              <Th>Supplier</Th>
              <Th>Origin</Th>
            </Tr>
          </Thead>
          <Tbody>
            {data.map((hop: Hop) => (
              <TableRow key={hop.id} hop={hop} />
            ))}
          </Tbody>
        </Table>
      </TableContainer>
    </>
  );
}
