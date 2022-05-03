import { useForm } from 'react-hook-form';
import { Hop } from '../types';
import useSWR, { useSWRConfig } from 'swr';
import {
  FormErrorMessage,
  FormLabel,
  FormControl,
  Input,
  Button,
  Flex,
  SimpleGrid,
  Select,
} from '@chakra-ui/react';
import axios from 'axios';
import { useRouter } from 'next/router';

export default function HopForm({ hop }: { hop: Hop }) {
  const { mutate } = useSWRConfig();
  const {
    handleSubmit,
    register,
    formState: { errors, isSubmitting },
  } = useForm({ defaultValues: hop });

  const router = useRouter();

  async function onSubmit(hop: Hop) {
    await axios.post('/api/1.0/inventory/hop', hop);
    mutate('/api/1.0/inventory/hop');
    router.push('/ingredients/hop');
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <SimpleGrid columns={2} spacing={10}>
        <FormControl isInvalid={Boolean(errors.name)}>
          <FormLabel htmlFor="name">Hop Name</FormLabel>
          <Input
            id="name"
            placeholder="name"
            {...register('name', {
              required: 'Hop name is required',
            })}
          />
          <FormErrorMessage>
            {errors.name && errors.name.message}
          </FormErrorMessage>
        </FormControl>
        <FormControl isInvalid={Boolean(errors.supplier)}>
          <FormLabel htmlFor="supplier">Supplier</FormLabel>
          <Input
            id="supplier"
            placeholder="supplier"
            {...register('supplier', {
              required: 'supplier is required',
            })}
          />
          <FormErrorMessage>
            {errors.supplier && errors.supplier.message}
          </FormErrorMessage>
        </FormControl>
        <FormControl isInvalid={Boolean(errors.origin)}>
          <FormLabel htmlFor="origin">Origin</FormLabel>
          <Input
            id="origin"
            placeholder="origin"
            {...register('origin', {
              required: 'Origin is required',
            })}
          />
          <FormErrorMessage>
            {errors.origin && errors.origin.message}
          </FormErrorMessage>
        </FormControl>
        <FormControl isInvalid={Boolean(errors.hopType)}>
          <FormLabel htmlFor="origin">Type</FormLabel>
          <Select
            id="hopType"
            placeholder="Select Hop Type"
            {...register('hopType', {
              required: 'Hop type is required',
            })}
          >
            <option value="PELLET">Pellet</option>
          </Select>
          <FormErrorMessage>
            {errors.hopType && errors.hopType.message}
          </FormErrorMessage>
        </FormControl>
      </SimpleGrid>
      <Flex justifyContent="end">
        <Button mt={2} mr={4} onClick={() => router.push('/ingredients/hop')}>
          Cancel
        </Button>
        <Button
          colorScheme="blue"
          mt={2}
          isLoading={isSubmitting}
          type="submit"
        >
          Save
        </Button>
      </Flex>
    </form>
  );
}
