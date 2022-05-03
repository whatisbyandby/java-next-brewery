import { useForm } from 'react-hook-form';
import { Recipe } from '../types';
import useSWR from 'swr';
import {
  FormErrorMessage,
  FormLabel,
  FormControl,
  Input,
  Button,
  Flex,
  Textarea,
  SimpleGrid,
  Select,
} from '@chakra-ui/react';
import axios from 'axios';
import { useRouter } from 'next/router';
import Fermentables from './Fermentable';

export default function RecipeForm({ recipe }: { recipe: Recipe }) {
  const router = useRouter();
  const {
    handleSubmit,
    register,
    formState: { errors, isSubmitting },
  } = useForm({ defaultValues: recipe });

  async function onSubmit(recipe: Recipe) {
    console.log(recipe);
    await axios.post('/api/1.0/recipe', recipe);
    await router.push('/recipes');
  }

  const { data, error } = useSWR('recipe-types', async () => {
    const res = await axios.get('/api/1.0/recipe/types');
    return res.data;
  });

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <SimpleGrid columns={2} spacing={10}>
        <FormControl isInvalid={Boolean(errors.name)}>
          <FormLabel htmlFor="name">Recipe Name</FormLabel>
          <Input
            id="name"
            placeholder="name"
            {...register('name', {
              required: 'Recipe name is required',
            })}
          />
          <FormErrorMessage>
            {errors.name && errors.name.message}
          </FormErrorMessage>
        </FormControl>
        <FormControl isInvalid={Boolean(errors.author)}>
          <FormLabel htmlFor="name">Author</FormLabel>
          <Input
            id="author"
            placeholder="author"
            {...register('author', {
              required: 'Recipe name is required',
            })}
          />
          <FormErrorMessage>
            {errors.author && errors.author.message}
          </FormErrorMessage>
        </FormControl>
        <FormControl isInvalid={Boolean(errors.recipeType)}>
          <FormLabel htmlFor="recipeType">Recipe Type</FormLabel>
          <Select
            placeholder="Select option"
            {...register('recipeType', {
              required: 'Recipe name is required',
            })}
          >
            <option value="ALL_GRAIN">All Grain</option>
            <option value="EXTRACT">Extract</option>
            <option value="PARTIAL_MASH">Partial Mash</option>
          </Select>
        </FormControl>
      </SimpleGrid>
      <FormControl>
        <FormLabel htmlFor="name">Description</FormLabel>
        <Textarea
          id="author"
          placeholder="description"
          {...register('description')}
        />
        <FormErrorMessage>
          {errors.description && errors.description.message}
        </FormErrorMessage>
      </FormControl>
      <SimpleGrid columns={2}>
        <Fermentables fermentableList={[]} />
      </SimpleGrid>
      <Flex justifyContent="end">
        <Button mt={2} mr={4} onClick={() => router.push('/recipes')}>
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
