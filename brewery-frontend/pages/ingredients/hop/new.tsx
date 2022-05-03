import { Container } from '@chakra-ui/react';
import HopForm from '../../../components/HopForm';
import Page from '../../../components/Page';
import { Hop, HopType } from '../../../types';

export default function NewHop() {
  const hop: Hop = {
    id: 0,
    name: '',
    origin: '',
    supplier: '',
    alphaAcid: 0,
    hopType: HopType.PELLET,
  };

  return (
    <Container maxW={'100%'} padding={2}>
      <HopForm hop={hop} />
    </Container>
  );
}
