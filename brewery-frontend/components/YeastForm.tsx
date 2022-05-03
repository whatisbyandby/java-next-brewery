import { useForm } from 'react-hook-form';
import { Yeast } from '../types';
import { useSWRConfig } from 'swr';
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

export default function YeastForm({ yeast }: { yeast: Yeast }) {
  const { mutate } = useSWRConfig();
  const {
    handleSubmit,
    register,
    formState: { errors, isSubmitting },
  } = useForm({ defaultValues: yeast });

  const router = useRouter();

  async function onSubmit(yeast: Yeast) {
    await axios.post('/api/1.0/inventory/yeast', yeast);
    mutate('/api/1.0/inventory/yeast');
    router.push('/ingredients/yeast');
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <SimpleGrid columns={2} spacing={10}>
        <FormControl isInvalid={Boolean(errors.name)}>
          <FormLabel htmlFor="name">Yeast Name</FormLabel>
          <Input
            id="name"
            placeholder="name"
            {...register('name', {
              required: 'Yeast name is required',
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
        <FormControl isInvalid={Boolean(errors.yeastType)}>
          <FormLabel htmlFor="origin">Type</FormLabel>
          <Select
            id="yeastType"
            placeholder="Select Yeast Type"
            {...register('yeastType', {
              required: 'Yeast type is required',
            })}
          >
            <option value="ALE">Ale</option>
          </Select>
          <FormErrorMessage>
            {errors.yeastType && errors.yeastType.message}
          </FormErrorMessage>
        </FormControl>
      </SimpleGrid>
      <Flex justifyContent="end">
        <Button mt={2} mr={4} onClick={() => router.push('/ingredients/yeast')}>
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
