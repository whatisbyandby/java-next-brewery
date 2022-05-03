import { useForm } from 'react-hook-form';
import { Miscellaneous } from '../types';
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

export default function MiscForm({ misc }: { misc: Miscellaneous }) {
  const { mutate } = useSWRConfig();
  const {
    handleSubmit,
    register,
    formState: { errors, isSubmitting },
  } = useForm({ defaultValues: misc });

  const router = useRouter();

  async function onSubmit(misc: Miscellaneous) {
    await axios.post('/api/1.0/inventory/misc', misc);
    mutate('/api/1.0/inventory/misc');
    router.push('/ingredients/miscellaneous');
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <SimpleGrid columns={2} spacing={10}>
        <FormControl isInvalid={Boolean(errors.name)}>
          <FormLabel htmlFor="name">Misc Name</FormLabel>
          <Input
            id="name"
            placeholder="name"
            {...register('name', {
              required: 'Misc name is required',
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
        <FormControl isInvalid={Boolean(errors.miscType)}>
          <FormLabel htmlFor="origin">Type</FormLabel>
          <Select
            id="miscType"
            placeholder="Select Misc Type"
            {...register('miscType', {
              required: 'Misc type is required',
            })}
          >
            <option value="HERB">Herb</option>
          </Select>
          <FormErrorMessage>
            {errors.miscType && errors.miscType.message}
          </FormErrorMessage>
        </FormControl>
      </SimpleGrid>
      <Flex justifyContent="end">
        <Button
          mt={2}
          mr={4}
          onClick={() => router.push('/ingredients/miscellaneous')}
        >
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
