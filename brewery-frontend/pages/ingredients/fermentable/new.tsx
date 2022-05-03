import { Container } from '@chakra-ui/react';
import FermentableForm from '../../../components/FermentableForm';
import Page from '../../../components/Page';
import { Fermentable } from '../../../types';

export default function NewHop() {
  const fermentable: Fermentable = {
    id: 0,
    name: '',
    origin: '',
    supplier: '',
    fermentableType: '',
    color: 0,
    potential: 0,
    yield: 0,
    diastaticPower: 0,
  };

  return (
    <Container maxW={'100%'} padding={2}>
      <FermentableForm fermentable={fermentable} />
    </Container>
  );
}
