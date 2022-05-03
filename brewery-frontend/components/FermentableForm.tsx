import { useForm } from 'react-hook-form';
import { Fermentable } from '../types';
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
  NumberInput,
  NumberInputField,
  NumberInputStepper,
  NumberIncrementStepper,
  NumberDecrementStepper,
  InputRightAddon,
} from '@chakra-ui/react';
import axios from 'axios';
import { useRouter } from 'next/router';

export default function FermentableForm({
  fermentable,
}: {
  fermentable: Fermentable;
}) {
  console.log(fermentable);
  const { mutate } = useSWRConfig();
  const router = useRouter();
  const {
    handleSubmit,
    register,
    formState: { errors, isSubmitting },
  } = useForm({ defaultValues: fermentable });

  async function onSubmit(fermentable: Fermentable) {
    await axios.post('/api/1.0/inventory/fermentable', fermentable);
    mutate('/api/1.0/inventory/fermentable');
    router.push('/ingredients/fermentable');
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <SimpleGrid columns={2} spacing={5}>
        <FormControl isInvalid={Boolean(errors.name)}>
          <FormLabel htmlFor="name">Fermentable Name</FormLabel>
          <Input
            id="name"
            placeholder="name"
            {...register('name', {
              required: 'Fermentable name is required',
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
              required: 'Supplier is required',
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
        <FormControl isInvalid={Boolean(errors.fermentableType)}>
          <FormLabel htmlFor="recipeType">Fermentable Type</FormLabel>
          <Select
            placeholder="Select option"
            {...register('fermentableType', {
              required: 'Recipe name is required',
            })}
          >
            <option value="GRAIN">Grain</option>
            <option value="SUGAR">Sugar</option>
            <option value="LIQUID_EXTRACT">Liquid Extract</option>
            <option value="DRY_EXTRACT">Dry Extract</option>
            <option value="ADJUNCT">Adjunct</option>
            <option value="OTHER">Other</option>
          </Select>
        </FormControl>
        <FormControl>
          <FormLabel htmlFor="color">Color</FormLabel>
          <NumberInput>
            <NumberInputField
              id="color"
              placeholder="color"
              {...register('color')}
            />
            <NumberInputStepper>
              <NumberIncrementStepper />
              <NumberDecrementStepper />
            </NumberInputStepper>
          </NumberInput>
          <FormErrorMessage>
            {errors.color && errors.color.message}
          </FormErrorMessage>
        </FormControl>
      </SimpleGrid>
      <Flex justifyContent="end">
        <Button
          mt={2}
          mr={4}
          onClick={() => router.push('/ingredients/fermentable')}
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
