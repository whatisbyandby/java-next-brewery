import { Container } from '@chakra-ui/react';
import MiscForm from '../../../components/MiscForm';
import { Miscellaneous } from '../../../types';

export default function NewHop() {
  const misc: Miscellaneous = {
    id: 0,
    name: '',
    origin: '',
    supplier: '',
    use: '',
    miscType: '',
  };

  return (
    <Container maxW={'100%'} padding={2}>
      <MiscForm misc={misc} />
    </Container>
  );
}
