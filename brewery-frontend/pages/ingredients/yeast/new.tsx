import { Container } from '@chakra-ui/react';
import YeastForm from '../../../components/YeastForm';
import { Yeast, YeastType } from '../../../types';

export default function NewHop() {
  const yeast: Yeast = {
    id: 0,
    name: '',
    origin: '',
    supplier: '',
    yeastType: YeastType.ALE,
    attenuation: 0,
    minimumAttenuation: 0,
    maximumAttenuation: 0,
    minimumTemperature: 0,
    maximumTemperature: 0,
    maximumABV: 0,
  };

  return (
    <Container maxW={'100%'} padding={2}>
      <YeastForm yeast={yeast} />
    </Container>
  );
}
